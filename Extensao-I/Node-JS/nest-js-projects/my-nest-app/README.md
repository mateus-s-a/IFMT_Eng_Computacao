# NestJS Guide



## 1. Setting up NestJS

Installing the NestJS CLI globally on your system:

```bash
npm install -g @nestjs/cli
```

After the installation is complete, we shall create a new NestJS project with:

```bash
nest new my-nest-app
```



## 2. Running up NestJS

To see the app in action, navigate into the project directory and start the development server:

```bash
cd my-nest-app
npm run start:dev
```



### Considerations.:

- **Controllers**: these handle incoming requests and return responses.

- **Services**: these contain the business logic of your application.

- **Modules**: these help you organize your code into reusable pieces.
