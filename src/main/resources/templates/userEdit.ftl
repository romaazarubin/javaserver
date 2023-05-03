<#import "parts/common.ftl" as c>

<@c.page>


    <style>
        html {
            background-color:#214c84;
            background-blend-mode:overlay;
            display:flex;
            align-items:center;
            justify-content:center;
            background-repeat:no-repeat;
            background-size:cover;
            height:100%;
        }

        body {
            background-color:transparent;
        }

        .registration-cssave{
            padding:50px 0;
        }


        .registration-cssave form:hover{
            box-shadow: 5px 5px 10px 10px white;
            transition-duration: .2s;
        }

        .registration-cssave form {
            max-width:1000px;
            padding:50px 70px;
            border-radius:10px;
            box-shadow:4px 4px 15px rgba(0, 0, 0, 0.2);
            background-color:#fff;
        }

        .registration-cssave form h3 {
            font-weight:bold;
            margin-bottom:30px;
        }

        .registration-cssave .item {
            border-radius:10px;
            margin-bottom:25px;
            padding:10px 20px;
        }

        .registration-cssave .create-account {
            border-radius:30px;
            padding:10px 20px;
            font-size:18px;
            font-weight:bold;
            background-color:#3f93ff;
            border:none;
            color:white;
            margin-top:20px;
        }

        @media (max-width: 576px) {
            .registration-cssave form {
                padding:50px 20px;
            }
        }

    </style>
<div class="registration-cssave">
    <form action="/user" method="post">
        <div class="form-group item"><input class="form-control item" type="text" name="username" value="${user.username}"></div>
        <#list roles as role>
            <div>
                <label><input class="form-control item" type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <div class="form-group item"><input class="form-control item" type="hidden" value="${user.id}" name="userId"></div>
        <div class="form-group item"><button class="form-control item" type="submit">Save</button></div>
    </form>
</div>
</@c.page>