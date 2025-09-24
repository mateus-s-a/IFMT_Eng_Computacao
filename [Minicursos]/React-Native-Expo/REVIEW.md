### Step-by-step:
1. 
```bash
npx create-expo-app nome-do-seu-app --template blank
npx expo install expo-router react-native-safe-area-context react-native-screens expo-linking expo-constants expo-status-bar
npm run start
```

2. `package.json`
```json
{
  "main": "expo-router/entry"
}
```

3. Depois de executar, aparece o menu abaixo no Terminal. Deve apertar 'a':
```plaintext
...
> Press a | open Android
> Press w | open Web

> Press j | open debugger
> Press r | reload app
> Press t | toggle menu
...
```

4. Instalar dependências:
```bash
npx expo install expo-router react-native-safe-area-context react-native-screens expo-linking expo-constants expo-status-bar
```

5. 
```js
// babel.config.js
module.exports = function (api) {
    ...
}
```

6. 
```bash
mkdir app
touch app/_layout.js
touch app/index.js
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
import HomeScreen from "../src/screens/HomeScreen.js";

export default function Index() {
    return <HomeScreen/>
}
```

7. 
```bash
mkdir src
mkdir src/components
mkdir src/screens
touch src/screens/HomeScreen.js
```

```js
// src/screens/HomeScreen.js

import React from "react";
import { SafeAreaView, View, Text, StyleSheet, TouchableOpacity } from "react-native";

export default function HomeScreen() {
    function handlePress() {
        console.log("Botão Clicado");
    }

    return (
        <SafeAreaView style={styles.container}>
            <View style={styles.content}>
                <Text style={styles.title}>HomeScreen</Text>
                <TouchableOpacity style={styles.button} onPress={handlePress}>
                    <Text style={styles.buttonText}>Pressiona Aqui</Text>
                </TouchableOpacity>
            </View>
        </SafeAreaView>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: "#000"
    },
    content: {
        flex: 1,
        alignItems: "center",
        justifyContent: "center",
        padding: 20
    },
    title: {
        color: "#fff",
        fontSize: 24,
        fontWeight: "bold",
        marginBottom: 8
    },
    subtitle: {
        color: "#bbb",
        fontSize: 14,
        marginBottom: 20,
        textAlign: "center"
    },
    button: {
        backgroundColor: "#6b07ff",
        paddingVertical: 12,
        paddingHorizontal: 18,
        borderRadius: 8
    },
    buttonText: {
        color: "#fff",
        fontSize: 16,
        fontWeight: 600
    }
});
```