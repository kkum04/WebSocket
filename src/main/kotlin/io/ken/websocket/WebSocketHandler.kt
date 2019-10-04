package io.ken.websocket

import org.springframework.web.socket.handler.AbstractWebSocketHandler
import org.springframework.web.socket.BinaryMessage
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession


class WebSocketHandler: AbstractWebSocketHandler() {

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println("New Text Message Received")
        session.sendMessage(message)
    }

    override fun handleBinaryMessage(session: WebSocketSession, message: BinaryMessage) {
        println("New Binary Message Received")
        session.sendMessage(message)
    }
}