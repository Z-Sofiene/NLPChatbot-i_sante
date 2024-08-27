async function displayEndpoints() {
    try {
        const response = await fetch('actuator/mappings');
        const endpoints = await response.json();

        const tableBody = document.getElementById('endpoints-list-body');
        tableBody.innerHTML = '';

        endpoints.contexts.Chatbot.mappings.dispatcherServlets.dispatcherServlet.forEach(mapping => {
            const fullClassName = mapping.details.handlerMethod.className;
            const controllerName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);

            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${controllerName}</td> 
                <td>${mapping.details.handlerMethod.name}</td>
                <td>${mapping.details.requestMappingConditions.methods}</td>
                <td>${mapping.details.requestMappingConditions.patterns}</td>
            `;

            tableBody.appendChild(row);
        });
    } catch (error) {
        console.error('Error fetching endpoints: ', error);
    }
}

window.onload = displayEndpoints;
