package com.pyf.house.extension;

import cn.hutool.core.util.IdUtil;
import com.pyf.house.filter.AppException;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author ADMIN
 */
@Component
public class AppRuntimeEnv {

    private ThreadLocal<String> token = ThreadLocal.withInitial(() -> null);

    private ThreadLocal<String> requestId = ThreadLocal.withInitial(() -> null);

    public AppRuntimeEnv ensureToken(String token) throws Exception {
        if (StringUtils.isBlank(token)) {
            throw new Exception("token入参为空");
        }
        this.token.set(token);
        return this;
    }

    public String getToken() {
        return token.get();
    }

    public String getRequestId() {
        return requestId.get();
    }

    public AppRuntimeEnv setRequestId(String requestId) {
        this.requestId.set(requestId);
        return this;
    }


}
