import React from "react";
import { View, Text, StyleSheet } from "react-native";

export default function Header({ title }) {
    return (
        <View style={styles.header}>
            <Text style={styles.title}>{title}</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    header: {
        paddingTop: 40,
        paddingBottom: 15,
        backgroundColor: "#6b0707ff",
        alignItems: "center",
    },
    title: {
        fontSize: 22,
        fontWeight: "bold",
        color: "#fff"
    },
});