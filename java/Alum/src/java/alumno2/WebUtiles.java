package utiles;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtiles {
    
    public void createCookie(HttpServletResponse response, String nombre, String valor) {
        Cookie cookie = new Cookie(nombre, valor);
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
    }
    
    public void deleteCookie(HttpServletRequest request, HttpServletResponse response, String nombre) {        
        Cookie cookie = getCookie(request, nombre);
        if (cookie != null) {
            cookie.setMaxAge(0); // Me la cargo
            response.addCookie(cookie);
        }    
    }
    
    public boolean isCookieInRequest(HttpServletRequest request, String nombre) {
        Cookie[] cookies = request.getCookies();
        
        if (cookies != null) {        
            for(Cookie cookie : cookies) {
                if (cookie.getName().equals(nombre))
                    return true;
            }
        }
        return false;
    }
    
    public Cookie getCookie(HttpServletRequest request, String nombre) {
        
        Cookie[] cookies = request.getCookies();
        
        if (cookies != null) {
            for(Cookie cookie : cookies) {
                if (cookie.getName().equals(nombre))
                    return cookie;
            }
        }
        return null;        
    }
}
