### Step-by-step:
1. 
```bash
npx create-expo-app nome-do-seu-app --template blank

npm run start
```

2. Depois de executar, aparece o menu abaixo no Terminal. Deve apertar 'a':
```plaintext
...
> Press a | open Android
> Press w | open Web

> Press j | open debugger
> Press r | reload app
> Press t | toggle menu
...
```

3. Instalar dependências:
```bash
npx expo install expo-router react-native-safe-area-context react-native-screens expo-linking expo-constants expo-status-bar
```

4. 
```js
// babel.config.js
module.exports = function (api) {
    ...
}
```

5. 
```bash
mkdir app
touch app/_layout.js
```

```js
// app/_layout.js

import React from "react"
import { Stack } from "expo-router"
import { SafeAreaView, Stylesheet } from "react-native"
import { StatusBar } from "expo-status-bar"

export default function RootLayout() {
    return (
        <SafeView style={styles.container}>
        <StatusBar style="light"/>
        <Stack screenOptions={{ headerShow: false }}/>
        </SafeView>
    )
}

const styles = Stylesheet.create({
    container: {
        flex: 1,
        background: "#000"
    }
})
```

```js
// app/index.js
import React from "react";
import HomeScreen from "../src/screen/HomeScreen";

export default function Index() {
    return <HomeScreen/>
}

```