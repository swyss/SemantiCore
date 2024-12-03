<template>
    <v-app :theme="theme">
      <v-app-bar class="px-3">
        <v-spacer></v-spacer>

        <v-btn
          :prepend-icon="theme === 'light' ? 'mdi-weather-sunny' : 'mdi-weather-night'"
          text="Toggle Theme"
          slim
          @click="toggleTheme"
        ></v-btn>
      </v-app-bar>

      <v-main>
        <router-view />
      </v-main>
      <AppFooter />
    </v-app>
</template>

<script setup>
  //
import AppFooter from "@/components/AppFooter.vue";
//
  import { useTheme } from 'vuetify'

  const theme = useTheme()

  function toggleTheme () {
    theme.global.name.value = theme.global.current.value.dark ? 'light' : 'dark'
  }
</script>
