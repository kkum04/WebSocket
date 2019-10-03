package io.ken.websocket

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry





@Configuration
@EnableWebSocket
class WebSocketConfiguration: WebSocketConfigurer {

    @Bean
    fun createWebSocketContainer(): ServletServerContainerFactoryBean {
        val container = ServletServerContainerFactoryBean()
        container.setMaxBinaryMessageBufferSize(1024000)
        return container
    }

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(WebSocketHandler(), "/socket").setAllowedOrigins("*")
    }
}