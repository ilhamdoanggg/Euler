document.getElementById('check-btn').addEventListener('click', function() {
    const inputElement = document.getElementById('text-input');
    const resultElement = document.getElementById('result');
    const inputText = inputElement.value;

    if (inputText === '') {
        alert('Please input a value');
        return;
    }

    const normalizedText = inputText.toLowerCase().replace(/[^a-z0-9]/g, '');
    const reversedText = normalizedText.split('').reverse().join('');
    const isPalindrome = normalizedText === reversedText;

    if (isPalindrome) {
        resultElement.textContent = `${inputText} is a palindrome`;
    } else {
        resultElement.textContent = `${inputText} is not a palindrome`;
    }
});
