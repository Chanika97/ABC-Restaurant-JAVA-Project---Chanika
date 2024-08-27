window.addEventListener('load', function() {
    // Set a delay for the preloader to remain visible (e.g., 3 seconds)
    setTimeout(function() {
        // Hide the preloader
        document.getElementById('preloader').style.display = 'none';
        // Show the content
        document.getElementById('content').style.display = 'block';
    }, 3000); // 3000 milliseconds = 3 seconds
});



  