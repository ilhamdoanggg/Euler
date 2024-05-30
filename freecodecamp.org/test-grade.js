// Assuming getAverage and getGrade functions are defined as follows:

function getAverage(scores) {
    if (scores.length === 0) {
        return 0;
    }
    let total = scores.reduce((sum, score) => sum + score, 0);
    return total / scores.length;
}

function getGrade(score) {
    if (score === 100) {
        return 'A++';
    } else if (score >= 90) {
        return 'A';
    } else if (score >= 80) {
        return 'B';
    } else if (score >= 70) {
        return 'C';
    } else if (score >= 60) {
        return 'D';
    } else {
        return 'F';
    }
}

function studentMsg(totalScores, studentScore) {
    // Calculate the class average
    const classAverage = getAverage(totalScores);
    
    // Determine the student's grade
    const studentGrade = getGrade(studentScore);
    
    // Check if the student passed
    const passed = studentScore >= 60;
    
    // Construct the message
    let message = "Class average: " + classAverage.toFixed(2) + ". Your grade: " + studentGrade + ". You ";
    if (passed) {
        message += "passed the course.";
    } else {
        message += "failed the course.";
    }
    
    return message;
}

// Example usage:
let totalScores = [100, 95, 80, 70, 65, 50];
let studentScore = 75;
console.log(studentMsg(totalScores, studentScore));  // Output: Class average: 76.67. Your grade: C. You passed the course.

studentScore = 55;
console.log(studentMsg(totalScores, studentScore));  // Output: Class average: 76.67. Your grade: F. You failed the course.
