# Flexive
- This is a fullstack project showcasing the Spring Framework with Spring MVC and Spring Security. It also features React.js and MYSQL
  
- It is a headless application where the front-end (written in React.js) can be used with any back-end framework

- User authentication is supported, and users with their investments are stored in a MYSQL database

- This application can be used to track stock investments, where money can be allocated to individual stocks.

- Stocks can be sorted by name and investment amount, and the application features an infinitely scrolling window where the stocks are stored

# Reflection
The biggest difficulty with this project was learning Spring Boot and the Java language to create a comprehensive back-end. Spring works very differently than other back-ends, but is more easily scalable and has vastly more features than other frameworks. Getting Spring Security to work was the hardest part of working with Spring, as it involves layering the security function on top of the other features of the application. I learned a lot about OOP, Java, Front-end development, and React.js as well creating this project. It was a fun challenge building a front-end that would work with any back-end I created for it, as long as the routes were set up correctly. It was very difficult to deploy this project as well and I had a lot of CORS issues between my front and back-end.

# What Would I Do Differently?
- If I could do this project over again, I would have chosen to forgoe Spring JWT as my security method and opted for a simple authentication solution. It was interesting learning about JWT, but it was not necessary for my project and created many issues in deployment.
- For my Front-end, I would have tried a CSS library I was not familiar with, like TailwindCSS. I liked working with BulmaCSS for its simplicity, but I want to be familiar with other libraries as well
- I would have made this a single page application. I could have consolidated the add wallet page into the primary page to make it look nicer.
