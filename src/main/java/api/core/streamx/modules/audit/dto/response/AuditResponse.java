package api.core.streamx.modules.audit.dto.response;


public record AuditResponse(
        String method ,
        String uri ,
        Integer codeStatus ,
        String httpStatus ,
        String timeStamp
) {}
