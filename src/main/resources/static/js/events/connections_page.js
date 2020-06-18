$(document).ready(function(){
    let currPage = 1;
    let pageSize = 12;
    let connections_list = $('#connections_list');
    $('#connections_link').addClass('active');
    getConnections('all', connections_list, currPage);
    connections_pages_count('all', pageSize, $('#paging'))
    $(document).on('click', '.page-btn', function() {
        let newPage = this.id.replace("p_", '');
        $('#pi_' + currPage).removeClass('active');
        currPage = newPage;
        $('#pi_' + newPage).addClass('active');
        getConnections('all', connections_list, newPage);
    });
});