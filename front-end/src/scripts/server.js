import express from "express";

const express = require("express");
const cors = require("cors");
const porta = process.env.porta || 7070;

const app = express();
app.use(cors());
app.use(express.json());

let usuarios = [];

app.get("/api/usuario", (req, res) => {
    res.json(usuarios);
});

app.post("/api/usuario", (req, res) => {
    const {email, usuario, senha} = req.body;

    if (!email || !usuario || !senha) {
        return res.status(400).json({ erro: "email, usuario e senha são obrigatorios"})
    }

    const novoUsuario = {
        id: usuarios.length + 1,
        email,
        usuario,
        senha
    };

    usuarios.push(novoUsuario);

    res.status(201).json(novoUsuario);
})