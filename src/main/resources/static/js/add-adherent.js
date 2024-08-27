function dateToString(date) {
            const d = new Date(date);
            let month = '' + (d.getMonth() + 1);
            let day = '' + d.getDate();
            const year = d.getFullYear();

            if (month.length < 2) month = '0' + month;
            if (day.length < 2) day = '0' + day;

            return [year, month, day].join('-');
        }

        function handleSubmit(event) {
            event.preventDefault();
            const form = document.getElementById('addAdherentForm');
            const bday = document.getElementById('date_de_naissance').value;

            let birthday = dateToString(bday);

            if (birthday == "NaN-NaN-NaN") { return; }

            const hiddenBirthdayInput = document.createElement('input');
            hiddenBirthdayInput.type = 'hidden';
            hiddenBirthdayInput.name = 'birthday';
            hiddenBirthdayInput.value = birthday;

            form.appendChild(hiddenBirthdayInput);

            form.submit();
        }
