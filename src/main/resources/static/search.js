document.addEventListener('DOMContentLoaded', function() {
    var searchForm = document.getElementById('search-form');
    var searchInput = document.getElementById('search-input');

    searchForm.addEventListener('submit', function(event) {
        event.preventDefault();
        var query = searchInput.value;

        // Example: Display the search query as an alert
        // You should replace this with actual search logic
        alert('Searching for: ' + query);
    });
});
