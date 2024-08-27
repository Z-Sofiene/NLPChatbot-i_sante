document.addEventListener('DOMContentLoaded', function() {
    const curlForm = document.getElementById('curlForm');

    if (curlForm) {
        curlForm.addEventListener('submit', function(event) {
            event.preventDefault();

            const endpoint = document.getElementById('endpoint').value;
            const url = 'http://localhost:10000/' + endpoint;

            fetch(url)
                .then(response => response.text())
                .then(data => {
                    document.getElementById('response').innerHTML = '<pre>' + data + '</pre>';
                })
                .catch(error => {
                    document.getElementById('response').innerHTML = '<pre>Error: ' + error + '</pre>';
                });
        });
    }
});
