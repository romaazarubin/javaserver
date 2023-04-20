<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org" lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Система перевозки грузов</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="bg-image"
     style="background-image: url('https://fileshare.gruzovichkof.ru/uploads/file-308-1602266934662.jpg'); height: 100vh; overflow: auto;">
    <span><a href="/login">Выход</a></span>
    <span><a href="/user">User list</a></span>
    <blockquote class="blockquote text-center">
        <h1>Система перевозки грузов</h1>
    </blockquote>
    <div class="row">
        <div class="col-md-8 offset-md-4">
            <h4>
                Поиск груза по любому критерию
            </h4>
            <form th:action="@{/}">
                <input type="text" name="keyword" id="keyword" size="30" th:value="${keyword}" required/>
                <input type="submit" class="btn btn-success btn-sm" value="Поиск"/>
                <input type="button" class="btn btn-warning btn-sm" value="Очистить" id="btnClear"
                       onclick="clearSearch()"/>
            </form>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/gh/tofsjonas/sortable@latest/sortable.min.js"></script>
    <table id="1" class="table table-striped table-hover sortable">
        <thead>
        <tr>
            <th scope="col">
                ID груза
            </th>
            <th scope="col">
                Название груза
            </th>
            <th scope="col">
                Содержимое груза
            </th>
            <th scope="col">
                Город отправки груза
            </th>
            <th scope="col">
                Дата отправки груза
            </th>
            <th scope="col">
                Город прибытия груза
            </th>
            <th scope="col">
                Дата прибытия груза
            </th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="client: ${listClient}">
            <th scope="row" class="text-white" th:text="${client.id}">
                ID груза отсутствует
            </th>
            <th scope="row" class="text-white" th:text="${client.name}">
                Название груза отсутствует
            </th>
            <th scope="row" class="text-white" th:text="${client.content}">
                Содержимое груза отсутствует
            </th>
            <th scope="row" class="text-white" th:text="${client.departure_date}">
                Дата отправки отсутствует
            </th>
            <th scope="row" class="text-white" th:text="${client.departure_city}">
                Город отправки отсутствует
            </th>
            <th scope="row" class="text-white" th:text="${client.arrival_city}">
                Город прибытия отсутствует
            </th>
            <th scope="row" class="text-white" th:text="${client.arrival_date}">
                Дата прибытия отсутствует
            </th>
            <td>
                <a th:href="@{'/edit/' + ${client.id}}">
                    <button type="button" class="btn btn-info">
                        Редактировать
                    </button>
                </a>
                <a th:href="@{'/delete/' + ${client.id}}">
                    <button type="button" class="btn btn-danger">
                        Удалить
                    </button>
                </a>
            </td>
        </tr>
        </tbody>
    </table>
    <p class="text-white">
        <script type="text/javascript">
            function getRowsColumns() {
                let table = document.getElementById('1')
                let tBody = table.querySelector('tbody')
                const count = tBody.querySelectorAll('tr').length;
                document.write('Количество грузов в компании: ' + count)
            }

            getRowsColumns()
        </script>
    </p>
    <a href="/new">
        <button type="button" class="btn btn-primary" data-togge="button" aria-pressed="false" autocomplete="off">
            Добавить груз
        </button>
    </a>
    <div>
        <canvas style="background-color: rgba(240,248,255);" height="400px" width="50%" id="myChart1"></canvas>
    </div>

    <div>
        <canvas style="background-color: rgba(240,248,255);" height="400px" width="50%" id="myChart2"></canvas>
    </div>

</div>
<style>
    footer{position:absolute;min-height: 100vh; left: 0; bottom: 0}
</style>
<footer class="footer">
    <script type="text/javascript">
        function clearSearch() {
            window.location = "[[@{/}]]";
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        let table = document.getElementById('1')
        let tBody = table.querySelector('tbody')
        let ths5 = tBody.querySelectorAll('th:nth-child(3)')

        let xValues = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24',
            '25', '26', '27', '28', '29', '30'];
        let xValues1 = ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь',
            'Ноябрь', 'Декабрь']

        let yValues5 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
        let yValues7 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

        for (let i = 0; i < ths5.length; i += 1) {
            let day = parseInt(ths5[i].innerText.slice(8, 10));
            console.log('This is a log message')
            console.log(`day: ${day}`);
            yValues5[day - 1] += 1
        }

        for (let i = 0; i < ths5.length; i += 1) {
            let month = parseInt(ths5[i].innerText.slice(5, 7));
            console.log(`month: ${month}`);
            yValues7[month - 1] += 1
        }

        console.log(yValues5)
        console.log(yValues7)
        console.log(table)
        console.log(tBody)
        console.log(ths5)

        new Chart('myChart1', {
            type: 'bar',
            data: {
                labels: xValues,
                datasets: [{
                    label: 'Гистограмма количества конференций',
                    data: yValues5,
                    borderWidth: 1,
                    fill: true,
                    backgroundColor: [
                        'rgb(1, 1, 1)'
                    ]
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
        new Chart('myChart2', {
            type: 'bar',
            data: {
                labels: xValues1,
                datasets: [{
                    label: 'Гистограмма количества конференций',
                    data: yValues7,
                    borderWidth: 1,
                    fill: true,
                    backgroundColor: [
                        'rgb(1, 1, 1)'
                    ]
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    </script>
</footer>
</body>
</html>


