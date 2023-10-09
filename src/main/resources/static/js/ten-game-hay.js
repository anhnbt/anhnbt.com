$(document).ready( function () {
    $('#TenLienQuanHay').DataTable({
        ajax: {
            url: "/nicknames?size=9999",
            dataSrc: 'content'
        },
        columns: [
            { data: 'name' },
            { data: 'nickname' }
        ]
    });
    $('#TenQuanDoanHay').DataTable();
} );