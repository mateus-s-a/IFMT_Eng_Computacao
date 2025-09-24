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
        backgroundColor: "#6b070f",
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