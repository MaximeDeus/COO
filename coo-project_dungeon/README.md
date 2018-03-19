Projet n°1: Donjon
=====================

#### AUTEURS: DEROISSART Maxime @deroissart | SASU Daniel @sasu

> **Note:** Toute manipulation(commande) décrite dans ce fichier est effectuée depuis le dossier
> racine du projet.

Contenu
=======

* [Présentation du TP et de ses objectifs](#présentation-du-tp-et-de-ses-objectifs)
* [Arborescence Du Projet](#arborescence-du-projet)
* [Comment récupérer le projet](#comment-récupérer-le-projet)
* [Compilation et exécution des tests](#compilation-et-exécution-des-tests)
* [Creation d'un exécutable .jar](#creation-dun-exécutable-jar)
* [Comment générer la documentation](#comment-générer-la-documentation)
* [Comment "nettoyer" le projet](#comment-nettoyer-le-projet)



Présentation du TP et de ses objectifs
======================================

- Se familiariser avec les types génériques
- Concevoir un projet en équipe, en respectant un cahier des charges (respect des consignes données, deadline..)


Arborescence Du Projet
----------------------
```
$ tree
.
├── pom.xml
├── README.md
└── src
    ├── main
    │   └── java
    │       └── fil
    │           └── coo
    │               └── donjon
    │                   ├── action
    │                   │   ├── Action.java
    │                   │   ├── AttackAction.java
    │                   │   ├── ChangeRoomAction.java
    │                   │   ├── LookAction.java
    │                   │   ├── RestAction.java
    │                   │   └── UseAction.java
    │                   ├── character
    │                   │   ├── DungeonCharacter.java
    │                   │   ├── Monster.java
    │                   │   └── Player.java
    │                   ├── DonjonGame.java
    │                   ├── item
    │                   │   ├── Gold.java
    │                   │   ├── Item.java
    │                   │   ├── LifePotion.java
    │                   │   ├── OneArmedBandit.java
    │                   │   ├── Potion.java
    │                   │   └── StrengthPotion.java
    │                   ├── room
    │                   │   ├── Direction.java
    │                   │   ├── ExitRoom.java
    │                   │   └── Room.java
    │                   └── tools
    │                       ├── RandomGenerator.java
    │                       ├── ScannerInt.java
    │                       └── WrongDirectionException.java
    └── test
        └── java
            └── fil
                └── coo
                    └── donjon
                        ├── action
                        │   ├── ActionTest.java
                        │   ├── AttackActionTest.java
                        │   ├── ChangeRoomActionTest.java
                        │   ├── LookActionTest.java
                        │   ├── RestActionTest.java
                        │   └── UseActionTest.java
                        ├── character
                        │   ├── DungeonCharacterTest.java
                        │   ├── MonsterTest.java
                        │   └── PlayerTest.java
                        ├── item
                        │   ├── GoldTest.java
                        │   ├── ItemTest.java
                        │   ├── LifePotionTest.java
                        │   ├── OneArmedBanditTest.java
                        │   ├── PotionTest.java
                        │   └── StrengthPotionTest.java
                        └── room
                            ├── DirectionTest.java
                            ├── ExitRoomTest.java
                            └── RoomTest.java

20 directories, 40 files

```

Comment récupérer le projet
-----------------------------

1. Lancer le terminal de commandes
2. Entrer la commande suivante:

```
$ git clone git@gitlab-etu.fil.univ-lille1.fr:deroissart/COO.git
```

Compilation et exécution des tests
----------------------------------
```
$ mvn test
```

> **Note:** Certains tests ont été mis en commentaire (1 dans AttackActionTest,1 dans ChangeRoomTest,2 dansUseActionTest), car empêche le bon fonctionnement de mvn package ("non prise en charge des input")

Creation d'un exécutable .jar
------------------------------


```
$ mvn package #création du package .jar
$ java -jar target/COO-Donjon-1.0-SNAPSHOT.jar # exécution
```

Comment générer la documentation
----------------------------------

```
$ mvn javadoc:javadoc
```

> **Note:** On retrouve le fichier index.html dans le dossier COO-Projet_Donjon/target/docs.


Comment "nettoyer" le projet
------------------------------

```
$ mvn clean
```


Cela supprimera le dossier target, l'archive exécutable, la documentation générée et enfin les fichiers compilés.
