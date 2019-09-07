# Automaticator
Completely automate your server with this simple plugin.

### Prerequisites
* Java 8+
* [Spigot 1.8.8](https://cdn.getbukkit.org/spigot/spigot-1.8.8-R0.1-SNAPSHOT-latest.jar)

### Default Configuration
```yml
automaticator:
  repeat:
    example:
      time: 10
      commands:
        - say Isso será repetido a cada 10 segundos.
  timer:
    example:
      day: quarta
      time: 4 19
      commands:
        - say Isso foi executado exatamente às 04:19
```

### Quick Example (Documented and translated to English)
```yml
automaticator:
  # BR: "repeat" será repetido a cada X segundos
  # EN: "repeat" will be repeated every X seconds
  repeat:
  
    # BR: Um nome qualquer, que não se repita
    # EN: Any name, not repeated
    example:
    
      # BR: Tempo em segundos
      # EN: Time in seconds
      time: 10
      
      # BR: Comandos que será executado toda vez que repetir isso
      # EN: Commands that will be executed every time you repeat this
      commands:
        - say Isso será repetido a cada 10 segundos.
        
  # BR: "timer" será repetido em uma data e horário específica
  # EN: "timer" will be repeated at a specific date and time
  timer:
  
    # BR: Um nome qualquer, que não se repita
    # EN: Any name, not repeated
    example:
    
      # BR: Dia da semana
      # EN: Day of the week
      day: quarta
      
      # BR: Horário que será executado (HORA MINUTO)
      # EN: Time to run (MINUTE TIME)
      time: 4 19
      
      # BR: Comandos que será executado toda vez que repetir isso
      # EN: Commands that will be executed every time you repeat this
      commands:
        - say Isso foi executado exatamente às 04:19
```
