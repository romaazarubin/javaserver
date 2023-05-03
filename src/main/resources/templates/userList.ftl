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


<form>
    <table>
        <thead>
        <div class="form-group item">
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
            </div>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <td><a href="/" style="text-decoration: none;"> Назад </a></td>


</form>
    </div>
</@c.page>