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



## 3. Concepts

- **Modules (`@Module`)**: act as organizers. They group controllers and providers into coherent blocks of functionality. `app.module.ts`

- **Controllers (`@Controller`)**: handle incoming HTTP requests . They delegate the complex logic to services. `app.controller.ts`

- **Services (`@Injectable`)**: handle the business logic and are listed in a module's `providers` array so they can be injected into controllers. `app.service.ts`
