$(function(){
    $(".proitems").click(function(){

        let seq=$(this).data("seq")
        document.location.href=`${rootPath}/detail?seq=${seq}`

    })

})