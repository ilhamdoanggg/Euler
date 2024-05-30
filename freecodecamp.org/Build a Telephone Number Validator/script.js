document.getElementById('check-btn').addEventListener('click', function () {
    const userInput = document.getElementById('user-input').value.trim();
    const resultsDiv = document.getElementById('results-div');

    if (userInput === '') {
        alert('Please provide a phone number');
        return;
    }

    if (!isValidPhoneNumber(userInput)) {
        resultsDiv.textContent = `Invalid US number: ${userInput}`;
    } else {
        resultsDiv.textContent = `Valid US number: ${userInput}`;
    }
});

document.getElementById('clear-btn').addEventListener('click', function () {
    document.getElementById('results-div').textContent = '';
});

function isValidPhoneNumber(number) {
    const regex = /^(1\s?)?(\(\d{3}\)|\d{3})[- ]?\d{3}[- ]?\d{4}$/;
    return regex.test(number);
}
