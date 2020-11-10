# Data Definition Language (DDL) 
```
CREATE TABLE IF NOT EXISTS `AttackCard`
(
    `attack_card_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `unit_card_id`   INTEGER                           NOT NULL,
    `type`           INTEGER                           NOT NULL,
    FOREIGN KEY (`unit_card_id`) REFERENCES `UnitCard` (`unit_card_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_AttackCard_unit_card_id` ON `AttackCard` (`unit_card_id`);

CREATE TABLE IF NOT EXISTS `Deck`
(
    `deck_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `user_id` INTEGER                           NOT NULL,
    `name`    TEXT                              NOT NULL,
    `qrCode`  TEXT                              NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Deck_user_id` ON `Deck` (`user_id`);

CREATE TABLE IF NOT EXISTS `Game`
(
    `game_id`                  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `user_id`                  INTEGER                           NOT NULL,
    `player_deck_id`           INTEGER                           NOT NULL,
    `computer_deck_id`         INTEGER                           NOT NULL,
    `is_player_units_alive`    INTEGER                           NOT NULL,
    `is_computer_units_alive`  INTEGER                           NOT NULL,
    `player_critical_chance`   INTEGER                           NOT NULL,
    `computer_critical_chance` INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY (`player_deck_id`) REFERENCES `Deck` (`deck_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
    FOREIGN KEY (`computer_deck_id`) REFERENCES `Deck` (`deck_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Game_user_id` ON `Game` (`user_id`);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Game_player_deck_id` ON `Game` (`player_deck_id`);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Game_computer_deck_id` ON `Game` (`computer_deck_id`);

CREATE TABLE IF NOT EXISTS `UnitCard`
(
    `unit_card_id`       INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `deck_id`            INTEGER                           NOT NULL,
    `unit`               INTEGER                           NOT NULL,
    `current_hit_points` INTEGER                           NOT NULL,
    `magic_hit_points`   INTEGER                           NOT NULL,
    FOREIGN KEY (`deck_id`) REFERENCES `Deck` (`deck_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_UnitCard_deck_id` ON `UnitCard` (`deck_id`);

CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`   INTEGER NOT NULL,
    `oauth_Key` TEXT    NOT NULL,
    PRIMARY KEY (`user_id`)
);
```
* [DDL](sql/ddl.sql)

* [DDL on Github](https://github.com/Dominguez1st/card-combat/blob/master/docs/sql/ddl.sql)


[*Return to previous page*](data-model-implementation.md)