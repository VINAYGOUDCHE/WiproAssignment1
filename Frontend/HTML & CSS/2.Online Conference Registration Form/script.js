document.getElementById('registrationForm').addEventListener('submit', function(event) {
    const fullName = document.getElementById('fullName').value;
    const email = document.getElementById('email').value;
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;
    const country = document.getElementById('country').value;
    const terms = document.getElementById('terms').checked;

    let valid = true;
    let errorMessage = '';

    // Check for required fields as per validation instructions
    if (fullName === '') {
        errorMessage += 'Full Name is required.\n';
        valid = false;
    }
    if (email === '') {
        errorMessage += 'Email Address is required.\n';
        valid = false;
    }
    if (username === '') {
        errorMessage += 'Username is required.\n';
        valid = false;
    }
    if (password === '') {
        errorMessage += 'Password is required.\n';
        valid = false;
    }
    if (country === '') {
        errorMessage += 'Country is required.\n';
        valid = false;
    }
    if (!terms) {
        errorMessage += 'You must agree to the Terms & Conditions.\n';
        valid = false;
    }

    // Password matching validation
    if (password !== confirmPassword) {
        errorMessage += 'Passwords do not match.\n';
        valid = false;
    }

    // Simple email format validation (as specified by the lab)
    const emailRegex = /^\S+@\S+\.\S+$/;
    if (email !== '' && !emailRegex.test(email)) {
        errorMessage += 'Please enter a valid email address (e.g., user@example.com).\n';
        valid = false;
    }

    if (!valid) {
        alert('Please correct the following errors:\n\n' + errorMessage);
        event.preventDefault(); // Prevent form submission
    }
});