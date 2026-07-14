> # Entidades Java Criadas - Streaming Video Platform ![java.png](java.png)

## Resumo das Entidades

**Todas as entidades foram criadas com base no diagrama ERD (Entity Relationship Diagram) em anexo. O projeto segue o padrão:**
- **ORM**: JPA/Hibernate com Jakarta Persistence
- **IDs**: Gerados automaticamente `(GenerationType.IDENTITY)`
- **Datas**: LocalDateTime
- **Serialização**: Lombok `(@Getter, @Setter, @NoArgsConstructor, @AllArgsConstructor, @Builder)`
- **JSON**: Usar `@JsonManagedReference` e `@JsonBackReference` para evitar ciclos

---

## Módulo: **channels**

### 1. **Channel.java**
- **Tabela**: `tb_channels`
- **Campos**:
  - `id` (PK, Long)
  - `name` (String)
  - `slug` (String)
  - `description` (String)
  - `bannerUrl` (TEXT)
  - `subscriberCount` (Integer)
  - `isMonetized` (Boolean)
  - `createdAt` (LocalDateTime)
- **Relacionamentos**:
  - `owner` (ManyToOne → Users)
  - `videos` (OneToMany → Video)
  - `subscriptions` (OneToMany → Subscription)

### 2. **Subscription.java**
- **Tabela**: `tb_subscriptions`
- **Campos**:
  - `id` (PK, Long)
  - `notifyEnabled` (Boolean)
  - `subscribedAt` (LocalDateTime)
- **Relacionamentos**:
  - `subscriber` (ManyToOne → Users)
  - `channel` (ManyToOne → Channel)

---

## Módulo: **videos**

### 3. **Video.java** (ATUALIZADO)
- **Tabela**: `tb_videos`
- **Campos**:
  - `id` (PK, Long)
  - `channelName` (String) - _renomeado de 'channel' para evitar conflito_
  - `title` (String)
  - `description` (String)
  - `thumbnailUrl` (TEXT)
  - `url` (String)
  - `recordCode` (String)
  - `status` (Enum: DRAFT, PUBLISHED, ARCHIVED)
  - `visibility` (Enum: PUBLIC, PRIVATE, UNLISTED)
  - `durationSeconds` (Integer)
  - `viewCount` (Long)
  - `likeCount` (Integer)
  - `tags` (JSONB)
  - `chapters` (JSONB)
  - `publishedAt` (LocalDateTime)
  - `shippingDate` (LocalDateTime)
  - `liked` (Boolean)
- **Relacionamentos**:
  - `users` (ManyToOne → Users)
  - `category` (ManyToOne → Category)
  - `channel` (ManyToOne → Channel)
  - `comments` (OneToMany → Comments)
  - `videoFiles` (OneToMany → VideoFile)
  - `playList` (ManyToOne → PlayList)
  - `playListItems` (OneToMany → PlayListItem)
  - `watchHistories` (OneToMany → WatchHistory)
  - `reactions` (OneToMany → Reaction)

### 4. **VideoFile.java** (NOVO)
- **Tabela**: `tb_video_files`
- **Campos**:
  - `id` (PK, Long)
  - `quality` (Enum: P720, P1080, P2K, P4K)
  - `storageKey` (String)
  - `hlsManifestUrl` (String)
  - `fileSizeBytes` (Long)
  - `codec` (String)
  - `bitrateKbps` (Integer)
- **Relacionamentos**:
  - `video` (ManyToOne → Video)

### 5. **PlayList.java** (ATUALIZADO)
- **Tabela**: `tb_playlist`
- **Campos**:
  - `id` (PK, Long)
  - `playListName` (String)
  - `visibility` (Enum: PUBLIC, PRIVATE, UNLISTED)
  - `createdAt` (LocalDateTime)
- **Relacionamentos**:
  - `users` (ManyToOne → Users)
  - `playListVideos` (OneToMany → Video)
  - `playListItems` (OneToMany → PlayListItem)

### 6. **PlayListItem.java** (NOVO)
- **Tabela**: `tb_playlist_items`
- **Campos**:
  - `id` (PK, Long)
  - `position` (Integer)
  - `addedAt` (LocalDateTime)
- **Relacionamentos**:
  - `playlist` (ManyToOne → PlayList)
  - `video` (ManyToOne → Video)

### 7. **Comments.java** (ATUALIZADO)
- **Tabela**: `tb_comments`
- **Campos**:
  - `id` (PK, Long)
  - `commentsMessage` (TEXT)
  - `commentsDate` (LocalDateTime)
  - `likeCount` (Integer)
  - `isPinned` (Boolean)
- **Relacionamentos**:
  - `users` (ManyToOne → Users)
  - `video` (ManyToOne → Video)
  - `parentComment` (ManyToOne → Comments - para respostas)
  - `replies` (OneToMany → Comments - respostas aninhadas)

### 8. **WatchHistory.java** (NOVO)
- **Tabela**: `tb_watch_history`
- **Campos**:
  - `id` (PK, Long)
  - `lastPositionSec` (Integer)
  - `completed` (Boolean)
  - `watchedAt` (LocalDateTime)
- **Relacionamentos**:
  - `user` (ManyToOne → Users)
  - `video` (ManyToOne → Video)

### 9. **Reaction.java** (NOVO)
- **Tabela**: `tb_reactions`
- **Campos**:
  - `id` (PK, Long)
  - `type` (Enum: LIKE, DISLIKE)
  - `createdAt` (LocalDateTime)
- **Relacionamentos**:
  - `user` (ManyToOne → Users)
  - `video` (ManyToOne → Video)

---

## Módulo: **users**

### 10. **Users.java** (ATUALIZADO)
- **Tabela**: `tb_users`
- **Campos**: (já existentes + novos)
  - `id` (PK, Long)
  - `name` (String)
  - `avatar` (TEXT)
  - `email` (String)
  - `password` (String)
  - `secretKey` (String)
  - `createdAt` (LocalDateTime)
  - `updatedAt` (LocalDateTime)
  - `status` (Boolean)
- **Relacionamentos**:
  - `followers` (OneToMany → Follower)
  - `videos` (OneToMany → Video)
  - `playLists` (OneToMany → PlayList)
  - `comments` (OneToMany → Comments)
  - `channels` (OneToMany → Channel)
  - `subscriptions` (OneToMany → Subscription)
  - `watchHistories` (OneToMany → WatchHistory)
  - `reactions` (OneToMany → Reaction)
  - `userPlans` (OneToMany → UserPlan)

### 11. **UserPlan.java** (NOVO)
- **Tabela**: `tb_user_plans`
- **Campos**:
  - `id` (PK, Long)
  - `status` (Enum: ACTIVE, INACTIVE, EXPIRED, CANCELLED)
  - `startsAt` (LocalDateTime)
  - `endsAt` (LocalDateTime)
- **Relacionamentos**:
  - `user` (ManyToOne → Users)
  - `plan` (ManyToOne → Plan)

---

## Módulo: **billing**

### 12. **Plan.java** (NOVO)
- **Tabela**: `tb_plans`
- **Campos**:
  - `id` (PK, Long)
  - `name` (String)
  - `priceBrl` (BigDecimal)
  - `billingCycle` (String)
  - `features` (JSONB)
- **Relacionamentos**:
  - `userPlans` (OneToMany → UserPlan)

---

## Diagrama de Relacionamentos

```
┌─────────────────────────────────────────────────────────────┐
│                         USERS                               │
│  id, name, email, password, avatar, etc.                    │
└─────────────────────────────────────────────────────────────┘
         │         │          │           │          │
         ├────────────────────┼───────────┼──────────┼─────────────┐
         │         │          │           │          │             │
    (1:N)│    (1:N)│     (1:N)│      (1:N)│     (1:N)│        (1:N)│
         │         │          │           │          │             │
    ┌────▼──┐ ┌────▼──┐ ┌─────▼──┐ ┌──────▼─┐ ┌───▼───┐ ┌────────▼─────┐
    │VIDEOS │ │ PLAYLISTS│ │COMMENTS│ │CHANNELS│ │SUBSCRI│ │WATCH_HISTORY │
    └─────┬─┘ └────┬──┘ └────┬──┘ └───┬────┘ └───┬───┘ └─────────┬─────┘
          │         │         │         │         │              │
         (1:N)     (1:N)     (1:N)    (1:N)    (1:1)          (1:1)
          │         │         │         │         │              │
    ┌─────▼─────────▼─────────▼─────────▼─────────▼──────────────▼─────┐
    │ VIDEO_FILES, PLAYLIST_ITEMS, REACTIONS, etc.                     │
    └──────────────────────────────────────────────────────────────────┘
```

---

## Status da Implementação

✅ **12 entidades criadas/atualizadas**
✅ **Compilação**: Sucesso (sem erros)
✅ **Padrão**: Seguindo a arquitetura do projeto
✅ **Relacionamentos**: Todos configurados com `@JsonManagedReference/@JsonBackReference`
✅ **Enums**: Criados para status, visibility, quality, reaction type

---

## Próximas Etapas (Opcional)

1. Criar **DTOs** para requisições/respostas das APIs
2. Criar **Repositories** (interfaces JpaRepository)
3. Criar **Services** (lógica de negócio)
4. Criar **Controllers** (endpoints REST)
5. Criar **testes unitários e de integração**

---

**Data**: 13/07/2026
**Desenvolvedor**: Ivan Santos

