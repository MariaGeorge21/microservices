// script.js

const messageInput = document.getElementById('message-input');
const sendButton = document.getElementById('send-button');
const messagesContainer = document.getElementById('messages-container');

// Send message to the server
function sendMessage() {
    const message = messageInput.value;
    // Send the message to the server using an appropriate API or WebSocket connection
    // Code to send the message to the server
    messageInput.value = ''; // Clear the input field
}

// Display received message
function displayMessage(message) {
    const messageElement = document.createElement('div');
    messageElement.textContent = message;
    messagesContainer.appendChild(messageElement);
}

// Event listeners
sendButton.addEventListener('click', sendMessage);

// Example: Receiving messages from the server
// WebSocket connection or AJAX request can be used to receive messages
// This is just a demonstration of displaying received messages
const receivedMessages = ['Hello', 'How are you?', 'Good to see you!'];
receivedMessages.forEach(message => displayMessage(message));
// Sending a chat message
const sendMessage = () => {
    const message = 'Hello, world!';
    fetch('/api/chat/send', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ message: message })
    })
    .then(response => {
        if (response.ok) {
            console.log('Message sent successfully');
            // Perform any necessary actions after a successful message send
        } else {
            console.error('Failed to send message');
            // Handle error scenario
        }
    })
    .catch(error => {
        console.error('Error sending message:', error);
        // Handle error scenario
    });
};

// Retrieving chat history
const getChatHistory = () => {
    fetch('/api/chat/history')
        .then(response => response.json())
        .then(chatHistory => {
            // Handle the received chat history
            console.log(chatHistory);
        })
        .catch(error => {
            console.error('Error retrieving chat history:', error);
            // Handle error scenario
        });
};
