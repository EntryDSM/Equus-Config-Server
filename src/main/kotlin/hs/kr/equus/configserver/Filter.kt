package hs.kr.equus.configserver

import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper
import javax.servlet.http.HttpServletResponse
@Component
class Filter: OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val requestWrapper = PathRequestWrapper(request)
        filterChain.doFilter(requestWrapper, response)
    }
}
class PathRequestWrapper(request: HttpServletRequest) : HttpServletRequestWrapper(request) {

    override fun getRequestURI(): String {
        return super.getRequestURI().replace("/equus-config", "")
    }

    override fun getRequestURL(): StringBuffer {
        return StringBuffer(super.getRequestURL().toString().replace("/equus-config", ""))
    }
}