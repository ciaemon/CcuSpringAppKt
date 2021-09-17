package com.ciaemon.niicdb.config

import com.ciaemon.niicdb.services.UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.servlet.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.sql.DataSource

@Configuration
@EnableWebSecurity
class SpringSecurityConfig(@Autowired private val dataSource: DataSource,
                           @Autowired private val userDetailsService: UserDetailsServiceImpl)
    : WebSecurityConfigurerAdapter() {
    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()


    override fun configure(auth: AuthenticationManagerBuilder?) {

        auth!!.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())

    }

    override fun configure(http: HttpSecurity?) {
        http {
            csrf {
                disable()
            }
            authorizeRequests {
                authorize("/", permitAll)
                authorize("/login", permitAll)
                authorize("/registration", permitAll)
                authorize("/profile", authenticated)
                authorize("user/**", hasRole("USER"))
                authorize("crystallographer/**", hasRole("CRYSTALLOGRAPHER"))
                authorize("admin/**", hasRole("admin"))
            }
            exceptionHandling {
                accessDeniedPage = "/403"
            }
            formLogin {
                loginProcessingUrl = "/login_process"
                loginPage = "/login"
                defaultSuccessUrl("/", alwaysUse = false)
                failureUrl = "/login?error=true"
            }
            logout {
                logoutUrl = "/logout"
                logoutSuccessUrl = "/"
            }
        }
    }
}