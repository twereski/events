**Events overview**

Przykładowa aplikacja prezentująca wykorzystanie eventów domenowych.

Do endpoointów  wpadają rządania (Command), które następnie przetwarzane są przez CommandHandler.
Rządania następnie przetwarzane są przez dedykowane assemblery. 
Agregat na podstawie informacji z warstwy aplikacji zmienia swój stan. Wynikiem poprawnie wykonanej operacji na agregacie
jest event. Wygenerowania eventu oznacza, że rządanie zostało zwalidowanie i operacja została przetworzona poprawnie 
i stała się faktem historycznym, którego odzwierdziedleniem jest event.
Event utrwalany jest w bazie danych - w odróżnieniu od klasycznego event sourcingu, 
gdzie agregat budowany jest z sekwencji eventów - agregat także jest zapisany w bazie.

Wygenerowane przez aplikację eventy są rozgłaszane za pomocą brokera wiadomości - RabbitMq.
Eventy mogą być wykorzystane do przetwarzania czasochłonnych zadań wewnątrz aplikacji lub do generowania historii.
Inne mikrosystemy, na które ma wpływ zdarzenie w aplikacji mogą zasubskrybować odpowiedni exchange i nasłuchiwać
płynących zdarzeń. 
Konsekwencją tego jest eventual consistency i duplikacja danych. 

Utwalenie danych:
Jako że z założenia agregat będzie zawsze pobierany w całości przechowywany jest w postaci zserializowanego JSON-a
Obiekt ProductContainer zawiera w sobie zserializowany Agregat plus meta dane.