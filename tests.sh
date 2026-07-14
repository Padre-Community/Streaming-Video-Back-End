#!/bin/bash

# ==============================================================================
# tests.sh - Script de automação de testes e análise de código (Maven)
# ==============================================================================

# Sai do script imediatamente se qualquer comando falhar (retornar status != 0)
set -e

# ----------------------------------------------------------------------------
# Configurações
# ----------------------------------------------------------------------------
SONAR_PROJECT_KEY="Stream-Video-Back-End"
SONAR_HOST_URL="http://localhost:9003"
SONAR_LOGIN="${SONAR_LOGIN:sqp_7a006677931982c56b53c90c134fc554a99680d5}"

# Cores para output no terminal (melhora a legibilidade)
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Função de log formatado
log_info() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

log_success() {
    echo -e "${GREEN}[SUCESSO]${NC} $1"
}

log_warn() {
    echo -e "${YELLOW}[AVISO]${NC} $1"
}

# ==============================================================================
# Funções de Teste
# ==============================================================================

run_junit() {
    log_info "Executando testes unitários (JUnit)..."
    mvn test
    log_success "Testes JUnit concluídos com sucesso."
}

run_integration() {
    log_info "Executando testes de integração (MockMVC/Integration Tests)..."
    mvn verify
    log_success "Testes de integração concluídos com sucesso."
}

run_jacoco() {
    log_info "Executando testes e gerando relatório de cobertura (JaCoCo)..."
    mvn clean test jacoco:report
    log_success "Relatório JaCoCo gerado com sucesso. Verifique: target/site/jacoco/index.html"
}

run_mutation() {
    log_info "Executando testes de mutação (PIT)..."
    mvn clean test pit:mutation
    log_success "Testes de mutação concluídos com sucesso."
}

run_sonar() {
    log_info "Executando análise estática com SonarQube..."
    # Nota: Certifique-se de que o SonarQube está rodando em http://localhost:9003
    mvn clean verify sonar:sonar \
        -Dsonar.projectKey="${SONAR_PROJECT_KEY}" \
        -Dsonar.host.url="${SONAR_HOST_URL}" \
        -Dsonar.login="${SONAR_LOGIN}"
    log_success "Análise SonarQube enviada com sucesso."
}

run_dependency_check() {
    log_info "Executando verificação de vulnerabilidades (OWASP Dependency Check)..."
    mvn org.owasp:dependency-check-maven:check
    log_success "Verificação de dependências concluída. Verifique o relatório em: target/dependency-check-report.html"
}

run_all() {
    log_info "Executando TODAS as etapas de teste e análise..."
    run_junit
    run_integration
    run_jacoco
    run_mutation
    run_sonar
    run_dependency_check
    log_success "Todas as etapas foram concluídas com sucesso!"
}

show_help() {
    echo "Uso: $0 [opção]"
    echo ""
    echo "Opções disponíveis:"
    echo "  junit               Executa apenas testes unitários (mvn test)"
    echo "  integration         Executa testes de integração (mvn verify)"
    echo "  jacoco              Executa testes e gera relatório de cobertura JaCoCo"
    echo "  mutation            Executa testes de mutação (PIT)"
    echo "  sonar               Executa análise de código com SonarQube"
    echo "  dependency          Executa verificação de vulnerabilidades OWASP"
    echo "  all                 Executa todas as etapas acima sequencialmente"
    echo "  help                Exibe esta mensagem de ajuda"
    echo ""
}

# ==============================================================================
# Ponto de entrada do script
# ==============================================================================

case "${1:-help}" in
    junit)
        run_junit
        ;;
    integration)
        run_integration
        ;;
    jacoco)
        run_jacoco
        ;;
    mutation)
        run_mutation
        ;;
    sonar)
        run_sonar
        ;;
    dependency)
        run_dependency_check
        ;;
    all)
        run_all
        ;;
    help|--help|-h)
        show_help
        ;;
    *)
        log_warn "Opção desconhecida: $1"
        show_help
        exit 1
        ;;
esac