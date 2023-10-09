Crypto-msg - mikroserwis umożliwiający tworzenie wiadomości, których istnienie
można ograniczyć czasowo, każda z wiadomości posiada swój identyfikator,
dzięki, któremu można ją odczytać. Po wyświetleniu zawartości wiadomości
znika ona z bazy danych.

RELEASE 0.0.1 - 
Dodanie profili, możliwość uruchamiania aplikacji w dwóch kontekstach
- atom
- integration

Pierwszy z nich służy do lokalnego testowania aplikacji
na bazie danych h2, aplikacja jest wtedy traktowana jako odrębna jednostka.

Profil integration przechowuje dane w bazie mongo.
Dla wersji 0.0.1 jest to wydanie produkcyjne.


RELEASE 0.0.2 -
Optymalizacja kodu oraz struktury projektowej.
Stworzenie dodatkowego serwisu, który implementuje 
podstawowe działania na bazie danych.