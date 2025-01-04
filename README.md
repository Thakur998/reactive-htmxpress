# HTMX Spring Boot Application

This is a simple Spring Boot application integrated with HTMX to provide dynamic content loading without page refreshes, following the MVC (Model-View-Controller) pattern. CSS is integrated for styling.

## Features
- **Spring Boot MVC architecture**
- **HTMX integration for dynamic content loading**
- **Customizable CSS styling**

template to quickly bootstart java htmx springboot based apps, currently using css sheet https://sakofchit.github.io/system.css/


How to create a simple webpage

After you clone the project you will find this class called Home... this will be landing page 


![Screenshot 2025-01-05 031829](https://github.com/user-attachments/assets/fbc52657-44e1-4ca5-b50a-f18e67adf94d)

every DOM object is NodeCreator in this project .... so if you want to create a new HTML tag , you can extend this nodecreator and start building 

see the following functions
setContent
toCreatePairNode

setContent will set the content inside the tags
toCreatePairNode will convert the content to string 

in this case it will convert the code to 

<div>
  <div class="window">
    <div class="title-bar">
      <button class="close" aria-label="Close"></button>
      <h1 class="title">App-Store</h1>
      <button class="resize" aria-label="Resize"></button>
    </div>
    <div class="separator"></div>
    <div class="window-pane">
      <div class="standard-dialog center scale-down" style="width:30rem;">
        <h1 class="dialog-text">Meow</h1>
        <p class="dialog-text">Meow Meow Meow Meow</p>
      </div>
    </div>
  </div>
</div>

also in project there are 2 css files , 1 is css.properties and another is styles.css 
you can also include javascript in script.js

htmx calls can be set using
setHtmxGet


![Screenshot 2025-01-01 051736](https://github.com/user-attachments/assets/0878cbf0-55ec-4c58-abb9-91e5f9ed3be6)

![05 01 2025_03 53 53_REC-ezgif com-video-to-gif-converter](https://github.com/user-attachments/assets/e208b32a-e044-4e8d-b900-10cf74657bed)

