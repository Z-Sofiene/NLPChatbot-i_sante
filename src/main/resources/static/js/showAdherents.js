async function displayAdherents() {
    try {
        // Fetch adherents data from the API
        const response = await fetch('api/adherents/list');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const adherents = await response.json();

        const tableBody = document.getElementById('adherents-list-body');
        tableBody.innerHTML = '';

        adherents.forEach(adherent => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${adherent.nom}</td>
                <td>${adherent.prenom}</td>
                <td>${adherent.cin}</td>
                <td>
                    <form action="/adherents/delete" method="post" onsubmit="return confirm('Are you sure you want to delete this adherent?');">
                    <input type="hidden" name="matricule" value="${adherent.matricule}">
                    <button type="submit" class="btn btn-danger">
                            <i class="fas fa-trash-alt"></i> Delete
                    </button>
                    </form>
                </td>
            `;
            tableBody.appendChild(row);
        });
    } catch (error) {
        console.error('Error fetching adherents:', error);
    }
}

// Call the function when the page loads
window.onload = displayAdherents;
