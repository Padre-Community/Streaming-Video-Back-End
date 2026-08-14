package api.core.streamx.modules.audit.processor;

import api.core.streamx.modules.audit.dto.request.AuditRequest;
import api.core.streamx.modules.audit.model.Audit;
import api.core.streamx.modules.audit.repository.AuditRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Date;

@Component
public class LogProcessorInterceptor implements HandlerInterceptor {
    private final AuditRepository auditRepository;

    public LogProcessorInterceptor(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);

        AuditRequest auditRequest = new AuditRequest(request.getMethod(), request.getRequestURI()
                , response.getStatus(), HttpStatus.valueOf(response.getStatus()).name(), new Date().toString());

        Audit audit = new Audit(null, auditRequest.method(), auditRequest.uri(),
                auditRequest.codeStatus(), auditRequest.httpStatus(), auditRequest.timeStamp());

        auditRepository.save(audit);
    }


}
