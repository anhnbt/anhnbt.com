$(document).ready( function () {
    $('#TenLienQuanHay').DataTable({
        "ajax": "https://anhnbt.com/ajax/ten-game-hay.php"
    });
    $('#TenQuanDoanHay').DataTable();
} );