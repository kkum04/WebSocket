package io.ken.websocket

import org.springframework.web.socket.handler.AbstractWebSocketHandler
import org.springframework.web.socket.BinaryMessage
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession


class WebSocketHandler: AbstractWebSocketHandler() {

    private val allSessions = mutableListOf<WebSocketSession>()

    override fun afterConnectionEstablished(session: WebSocketSession) {
        val found = allSessions.find { it.id == session.id }
        if (found == null) {
            println("New Session Connected id: ${session.id}")
            allSessions.add(session)
        }
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        allSessions.find { it.id == session.id } ?: return

        println("Session Closed id: ${session.id}")
        allSessions.remove(session)
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println("New Text Message Received")
        allSessions.forEach {
            it.sendMessage(message)
        }
    }

    override fun handleBinaryMessage(session: WebSocketSession, message: BinaryMessage) {
        println("New Binary Message Received")
        session.sendMessage(message)
    }


}
