document.addEventListener('DOMContentLoaded', () => {
    const sendButton = document.getElementById('sendButton');
    const userInput = document.getElementById('userInput');
    const responseOutput = document.getElementById('responseOutput');

    sendButton.addEventListener('click', async () => {
        const message = userInput.value.trim();
        if (message === '') {
            responseOutput.textContent = 'Please enter a message.';
            return;
        }

        try {
            const response = await fetch('http://localhost:10000/api/chatbot', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ message })
            });

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

            const data = await response.json();
            responseOutput.textContent = data.response;
        } catch (error) {
            responseOutput.textContent = `Error: ${error.message}`;
        }
    });
});
