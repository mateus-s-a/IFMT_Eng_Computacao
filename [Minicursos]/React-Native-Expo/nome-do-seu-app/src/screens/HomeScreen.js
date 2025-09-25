import React, { useState, useEffect } from "react";
import { 
    SafeAreaView, View, Text, StyleSheet,
    ImageBackground, Dimensions, ActivityIndicator, ScrollView,
    TouchableOpacity 
} from "react-native";
import Header from "../components/Header.js";
// import MoviesScroll from '../components/MoviesScroll.js';
// import Footer from '../components/Footer.js';
import { getPopularMovies } from "../api/api.js";

const { width } = Dimensions.get('window');

export default function HomeScreen() {
    const [featureMovie, setFeatureMovie] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        async function fetchFeaturedMovie() {
            try {
                const movies = await getPopularMovies();
                if (movies && movies.length > 0) {
                    setFeatureMovie(movies[0]);
                }
            } catch (error) {
                console.error("Erro ao buscar filme em destaque:", error);
            } finally {
                setLoading(false);
            }
        }
        fetchFeaturedMovie();
    }, []);

    return (
        <View style={styles.container}>
            <Header title={"🎬 Catálogo de Filmes"} />
            <View style={styles.heroContainer}>
                {loading ? (
                    <View style={styles.loadingHero}>
                        <ActivityIndicator size="large" color="#e50914"/>
                        <Text style={styles.loadingText}>Carregando filme em destaque...</Text>
                    </View>
                ) : featureMovie ? (
                    <ImageBackground
                        source={{
                            uri: `https://image.tmdb.org/t/p/original${featureMovie.backdrop_path || featureMovie.poster_path}`
                        }}
                        style={styles.hero}
                        resizeMode="cover"
                    >
                        <View style={styles.gradientOverlay}/>
                        <View style={styles.heroContent}>
                            <View style={styles.badge}>
                                <Text style={styles.badgeText}>EM DESTAQUE</Text>
                            </View>
                            <Text style={styles.heroTitle}>{featureMovie.title}</Text>
                            <Text style={styles.herosubTitle} numberOfLines={2}>
                                {featureMovie.overview || "Descubra os melhores filmes do momento"}
                            </Text>
                            <View style={styles.heroInfo}>
                                <View style={styles.ratingBadge}>
                                    <Text style={styles.ratingText}>⭐ {featureMovie.vote_average?.toFixed(1)}</Text>
                                </View>
                                <Text style={styles.yearText}>
                                    {featureMovie.release_date ? new Date(featureMovie.release_date).getFullYear() : ''}
                                </Text>
                                <Text style={styles.genreText}>
                                    {featureMovie.adult ? '+18' : 'Livre'} - Popular
                                </Text>
                            </View>
                        </View>
                        
                        <View style={styles.bottomFade}></View>
                    </ImageBackground>
                ) : (
                    <View style={styles.errorHero}>
                        <Text style={styles.errorText}>Erro ao carregar filme em destaque</Text>
                    </View>
                )}
            </View>
        </View>
    );
    
    // function handlePress() {
    //     console.log("Botão Clicado");
    // }

    // return (
    //     <SafeAreaView style={styles.container}>
    //         <Header title={"Teste"}/>
    //         <View style={styles.content}>
    //             <Text style={styles.title}>HomeScreen</Text>
    //             <Text style={styles.subtitle}>Minha vvv tela inicial simples ✌️</Text>
                
    //             <TouchableOpacity style={styles.button} onPress={handlePress}>
    //                 <Text style={styles.buttonText}>Pressiona Aqui</Text>
    //             </TouchableOpacity>
    //         </View>
    //     </SafeAreaView>
    // );
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