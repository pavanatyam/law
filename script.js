function navigateHome() {
    window.location.href = 'home.html';
}
function navigateAbout() {
    window.location.href = 'about.html';
}
function navigateBlog() {
    window.location.href = 'blog.html';
}
function navigateLogin() {
    window.location.href = 'login.html';
}
function navigateQuiz(){
    window.location.href = '1sthtml.html';
}

var acc = document.getElementsByClassName("accordion");
for (var i = 0; i < acc.length; i++) {
    acc[i].addEventListener("click", function() {
        var panel = this.nextElementSibling;
        if (panel.style.display === "block") {
            panel.style.display = "none";
        } else {
            panel.style.display = "block";
        }
    });
}
