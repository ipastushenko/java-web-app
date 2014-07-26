package com.ipastushenko.core.utils;

import com.ipastushenko.core.model.UserDetailsImpl;

import javax.servlet.http.HttpSession;

/**
 * Session utils
 */
public class SessionUtils {
    private SessionUtils(){
    }

    /**
     * check bad credentials and remove attribute from session
     * @param session session
     * @return true if bad credentials exists
     */
    public static boolean checkBadCredentials(HttpSession session) {
        Object obj = session.getAttribute(SessionAttributeCode.BAD_CREDENTIALS.name());
        if (obj != null) {
            session.removeAttribute(SessionAttributeCode.BAD_CREDENTIALS.name());
            return true;
        }
        return false;
    }

    public static String getNotConfirmedUsername(HttpSession session) {
        Object obj = session.getAttribute(SessionAttributeCode.NOT_CONFIRMED_USERNAME.name());
        if (obj != null) {
            String username = (String) obj;
            session.removeAttribute(SessionAttributeCode.NOT_CONFIRMED_USERNAME.name());
            return username;
        }

        return null;
    }

    public static UserDetailsImpl getCurrentUserDetails(HttpSession session) {
        Object obj = session.getAttribute(SessionAttributeCode.CURRENT_USER.name());
        if (obj != null) {
            if (obj instanceof UserDetailsImpl) {
                return (UserDetailsImpl)obj;
            }
        }

        return null;
    }
}
