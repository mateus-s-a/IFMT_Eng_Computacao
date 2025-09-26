import React from "react";
import { View, Text, StyleSheet, TouchableOpacity } from "react-native";
import { router } from "expo-router";

export default function Footer() {
    const handleSupportPress = () => {
        router.push("/support");
    };

    return (
        <View style={styles.footer}>
            <View style={styles.footerContent}>
                <Text style={styles.copyright}>
                    ©️ 2025 CineCatalog - Dados TMDB
                </Text>

                <TouchableOpacity style={styles.supportButton} onPress={handleSupportPress}>
                    <Text style={styles.supportText}>💬 Suporte</Text>
                </TouchableOpacity>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    footer: {
        backgroundColor: "#f5f5f5",
        borderTopWidth: 1,
        borderTopColor: "#e0e0e0",
        marginTop: 30,
        position: 'absolute',
        bottom: 0,
        width: '100%'
    },
    footerContent: {
        flexDirection: "row",
        justifyContent: "space-between",
        alignItems: "center",
        paddingHorizontal: 20,
        paddingVertical: 15,
    },
    copyright: {
        fontSize: 12,
        color: "#666",
    },
    supportButton: {
        backgroundColor: "#e50914",
        paddingHorizontal: 15,
        paddingVertical: 8,
        borderRadius: 20,
    },
    supportText: {
        color: "#fff",
        fontSize: 12,
        fontWeight: "600",
    },
});