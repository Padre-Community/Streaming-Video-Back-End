package api.core.streamx.modules.audit.dto.request;

public record AuditRequest(
        String method ,
        String uri ,
        Integer codeStatus ,
        String httpStatus ,
        String timeStamp
){}
