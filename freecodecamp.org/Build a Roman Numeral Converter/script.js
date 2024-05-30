document.getElementById('convert-btn').addEventListener('click', function() {
    const numberElement = document.getElementById('number');
    const outputElement = document.getElementById('output');
    const number = parseInt(numberElement.value);

    if (isNaN(number)) {
        outputElement.textContent = 'Please enter a valid number';
        return;
    }

    if (number < 1) {
        outputElement.textContent = 'Please enter a number greater than or equal to 1';
        return;
    }

    // if (number >= 4000) {
    //     outputElement.textContent = 'Please enter a number less than or equal to 3999';
    //     return;
    // }

    outputElement.textContent = convertToRoman(number);
});

function convertToRoman(num) {
    const romanNumeralMap = [
        { value: 1000, numeral: 'M' },
        { value: 900, numeral: 'CM' },
        { value: 500, numeral: 'D' },
        { value: 400, numeral: 'CD' },
        { value: 100, numeral: 'C' },
        { value: 90, numeral: 'XC' },
        { value: 50, numeral: 'L' },
        { value: 40, numeral: 'XL' },
        { value: 10, numeral: 'X' },
        { value: 9, numeral: 'IX' },
        { value: 5, numeral: 'V' },
        { value: 4, numeral: 'IV' },
        { value: 1, numeral: 'I' }
    ];

    let roman = '';

    for (const { value, numeral } of romanNumeralMap) {
        while (num >= value) {
            roman += numeral;
            num -= value;
        }
    }

    return roman;
}
