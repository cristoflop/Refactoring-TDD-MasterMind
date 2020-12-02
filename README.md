## Practica sobre TDD Y Refactorización del Master Cloud Apps 2020 de la URJC
## Autor: Cristofer López Cabañas

##### 1. Añadidas las clases genericas de ClosedInterval, Menu, Command

##### 2. Test de la clase Session
    + Añadidos métodos de test la clase session en la clase SessionTest
    + Implementada clase Session y refactorizada para pasar los test
    
##### 3. Test de la clase ProposalController aplicando MVC.pv
    + Refactor de la clase ProposalController aplicando MVC.pv para pasar los test

##### 4. Añadidas las clases de test de PlayController, UndoController, RedoController
    + Implementadas las clases de PlayController con el ProposalController para llevar el flujo de la aplicacion y pasar los test
    + Refactor de la clase ProposalController para ser llamada desde PlayController
    + Implementas las clases de RedoController y UndoController para ser llamadas desde PlayController siguiendo la arquitectura MVC.pv
    
##### 5. Añadidas las clases de test de ConsolePlayMenu, PlayCommand, UndoCommand, RedoCommand
    + Implementadas las clases de los commandos y el menu llamado por el PlayController
    + Refactor de la clase ProposalView, creando la clase GameView llamada por el PlayController para mostrar los intentos
    + Los comandos tienen una inversion de dependencias con el PlayController para llamar a su metodo correspondiente
    ++ Error en la clase de test ConsolePlayMenuTest (error con la lista mockeada para devolver un comando u otro para ser utilizados)
