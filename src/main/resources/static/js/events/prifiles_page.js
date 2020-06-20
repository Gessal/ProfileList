$(document).ready(function(){
    let profileSystem = 'all';
    let currPage = 1;
    let pageSize = 12;
    let profiles_list = $('#profiles_container');
    $('#all_profiles_link').addClass('active');
    getProfiles(profileSystem, profiles_list, currPage);
    getSystems($('#psystems'));
    profiles_pages_count(profileSystem, pageSize, $('#paging'))
    $(document).on('click', '.page-btn', function() {
        let newPage = this.id.replace("p_", '');
        $('#pi_' + currPage).removeClass('active');
        currPage = newPage;
        $('#pi_' + newPage).addClass('active');
        getProfiles(profileSystem, profiles_list, newPage);
    });
});