Feature: Smoke
  Как пользователь
  Я хочу запустить приложение и пройтись по его основным разделам
  Таким образом я проверю, что приложение в целом работает

  Scenario: Проверка навигации
    Given Пользователь запускает приложение, расположенное по пути 'C:\\Program Files\\Energomera\\cEnergo\\ceShell.View.Win.exe'
    When Пользователь кликает по пункту "Вид" главного меню
    Then Пользователь попадает на вкладку "Вид"